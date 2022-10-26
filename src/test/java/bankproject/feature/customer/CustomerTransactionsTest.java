package bankproject.feature.customer;

import org.junit.Before;
import org.junit.Test;

import bankproject.model.BankConstants;
import bankproject.WebHook;
import bankproject.page_object_model.CustomerAccountPage;
import bankproject.page_object_model.CustomerLoginPage;
import bankproject.page_object_model.CustomerTransactionsPage;

public class CustomerTransactionsTest extends WebHook {
    CustomerAccountPage customerAccountPage;

         String messageExceedBalanceLimit = "Transaction Failed. You can not withdraw amount more than the balance.";
         String messageDepositSuccessfully = "Deposit Successful";
         String messageWithdrawSuccessfully = "Transaction successful";

         int amount = 200;
         String depositType = "Credit";
         String withdrawType = "Debit";

        @Before
        public void classSetUp()
        {
            CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
            customerLoginPage.goTo();
            customerAccountPage = customerLoginPage.login(BankConstants.CustomerAccountValid.CustomerName);
        }

        @Test
        public void customer_deposit_money_with_valid_amount()
        {
            int currentBalance = customerAccountPage.getBalance();
            customerAccountPage.deposit().withAmount(amount);

            int expectedBalance = currentBalance + amount;

            customerAccountPage.deposit().verifyMessage(messageDepositSuccessfully);
            customerAccountPage.verifyBalance(expectedBalance);

            customerAccountPage.transactions().VerifyLastCustomerTransaction(amount,depositType);
        }

        @Test
        public void validate_customer_withdraw_the_money_that_exceed_the_balance() {
            customerAccountPage.deposit().withAmount(amount);

            int currentBalance = customerAccountPage.getBalance();
            int exceedBalanceLimitNumber = currentBalance + 1;
            customerAccountPage.withdrawl().withAmount(exceedBalanceLimitNumber);

            customerAccountPage.withdrawl().verifyMessage(messageExceedBalanceLimit);
            customerAccountPage.verifyBalance(currentBalance);
        }

        @Test
        public void customer_withdraw_money_with_valid_amount() {
            customerAccountPage.deposit().withAmount(amount);
            int currentBalance = customerAccountPage.getBalance();

            customerAccountPage.withdrawl().withAmount(amount);
            int expectedBalance = currentBalance - amount;

            customerAccountPage.withdrawl().verifyMessage(messageWithdrawSuccessfully);
            customerAccountPage.verifyBalance(expectedBalance);
            customerAccountPage.transactions().VerifyLastCustomerTransaction(amount, withdrawType);
        }

        @Test
        public void customer_reset_the_customer_transactions() {
            customerAccountPage.deposit().withAmount(amount);
            customerAccountPage.deposit().withAmount(amount);
            CustomerTransactionsPage transactionPage = customerAccountPage.transactions();
            transactionPage.reset();
            transactionPage.verifyNumberOfTransactions(0);
        }
}
