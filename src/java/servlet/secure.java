/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;

/**
 *
 * @author root
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/proj",
        callerQuery = "select u_password from user where u_name=?",
        groupsQuery = "select name from groups where user_name=?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)
@ApplicationScoped
//@FormAuthenticationMechanismDefinition(
//        loginToContinue=@LoginToContinue(
//                loginPage="login.jsp",
//                errorPage ="error.jsp"
//        )
//)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue=@LoginToContinue(
                loginPage="login-reg/login.jsf",
                errorPage = "error.jsp"
        )
)
public class secure {

      
        

}
