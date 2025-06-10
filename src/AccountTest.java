//import org.junit.Assert;
//import org.junit.Test;
//
//public class AccountTest {
//    private double epsilon = 1e-6;
//
//    @Test
//    public void accountCannotHaveNegativeOverdraftLimit() {
//        Account account = new Account(-20);
//
//        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
//    }
//
//    @Test
//    public void depositCannotHaveNegative() {
//        Account account = new Account(-20);
//        account.deposit(100d);
//
//        Assert.assertFalse(account.deposit(-50d));
//    }
//
//    @Test
//    public void withdrawCannotHaveNegative() {
//        Account account = new Account(-20);
//        account.deposit(50d);
//
//        Assert.assertFalse(account.withdraw(-50d));
//    }
//
//    @Test
//    public void accountCannotOverstepDraftLimit() {
//        Account account = new Account(100);
//        account.deposit(100d);
//        Assert.assertEquals(100d, account.getOverdraftLimit(), epsilon);
//        Assert.assertEquals(100d, account.getBalance(), epsilon);
//        Assert.assertFalse(account.withdraw(1500d));
//    }
//
//    @Test
//    public void deposit() {
//        Account account = new Account(20);
//        Assert.assertTrue(account.deposit(100d));
//        Assert.assertTrue(account.withdraw(120d));
//
//        Assert.assertEquals(-20d, account.getBalance(), epsilon);
//    }
//
//    @Test
//    public void withdraw() {
//        Account account = new Account(20);
//        Assert.assertTrue(account.deposit(50d));
//        Assert.assertTrue(account.withdraw(40d));
//        Assert.assertTrue(account.withdraw(30d));
//
//        Assert.assertEquals(-20d, account.getBalance(), epsilon);
//    }
//}