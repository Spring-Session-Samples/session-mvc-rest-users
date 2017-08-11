<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Demonstrates Multi User Log In</title>
    </head>
<body>

          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <c:url value="/" var="homeUrl"/>
              <li class="active"><a id="navHome" href="${homeUrl}">Home</a></li>
              <li>
                <c:url value="/link.jsp" var="linkUrl"/>
                <a id="navLink" href="${linkUrl}">Link</a>
              </li>
            </ul>
            
                <ul>
                  <li class="dropdown">
                    <a id="toggle" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                    <c:out value="${username}"/></a>
                    <ul id="user-menu" class="dropdown-menu" role="menu">
                      <c:if test="${currentAccount != null}">
                          <li><a id="logout" href="${currentAccount.logoutUrl}">Log Out</a></li>
                          <li><a id="addAccount" href="${addAccountUrl}">Add Account</a></li>
                      </c:if>
                      <c:if test="${not empty accounts}">
                          <li class="divider"></li>
                          <li class="dropdown-header">Switch Account</li>
                          <li class="divider"></li>
                      </c:if>
                      <c:forEach items="${accounts}" var="account">
                          <c:set var="encodedUsername">
                            <c:out value="${account.username}"/>
                          </c:set>
                          <li><a id="switchAccount${encodedUsername}" href="${account.switchAccountUrl}"><c:out value="${account.username}"/></a></li>
                      </c:forEach>
                    </ul>
                  </li>
                </ul>
          </div><!--/.nav-collapse -->
        

        <h1>Description</h1>
        <p>This application demonstrates how to use Spring Session to authenticate as multiple users at a time. View authenticated users in the upper right corner.</p>

        <c:choose>
            <c:when test="${username == null}">
                <h1>Please Log In</h1>
                <p>You are not currently authenticated with this session. You can authenticate with any username password combination that are equal. A few examples to try:</p>
                <ul>
                    <li><b>Username</b> rob and <b>Password</b> rob</li>
                    <li><b>Username</b> luke and <b>Password</b> luke</li>
                </ul>
                <c:if test="${param.error != null}">
                    <div id="error" class="alert alert-danger">Invalid username / password. Please ensure the username is the same as the password.</div>
                </c:if>
                <c:url value="/login" var="loginUrl"/>
                <form action="${loginUrl}" method="post">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input id="username" type="text" name="username"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input id="password" type="password" name="password"/>
                    </div>
                    <input type="submit" value="Login"/>
                </form>
            </c:when>
            <c:otherwise>
                <h1 id="un"><c:out value="${username}"/></h1>
                <p>You are authenticated as <b><c:out value="${username}"/></b>. Observe that you can <a href="${linkUrl}">navigate links</a> and the correct session is used. Using the links in the upper right corner you can:</p>
                <ul>
                    <li>Log Out</li>
                    <li>Switch Accounts</li>
                    <li>Add Account</li>
                   </ul>
            </c:otherwise>
        </c:choose>
</body>
</html>
