package Pages._0_Login;

public class LoginAction {
    private final P01_LoginPage loginPage;

    // ✅ ده هو الـ Constructor Injection
    public LoginAction(P01_LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    // ✅ ميثود بتنفذ عملية اللوجين
    public void loginWith(String username, String password) {
        loginPage.enterUsername(username)
                .enterPassword(password)
                .ClickOnLoginButton();
    }
}
