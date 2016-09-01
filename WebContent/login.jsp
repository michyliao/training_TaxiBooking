<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<div class="col-sm-offset-4">
	<h3>User Login</h3>
</div>


<form class="form-horizontal" action="Login">
	<div class="form-group">
		<label for="inputEmail3" class="col-sm-3 control-label">Email</label>
		<div class="col-sm-9">
			<input type="email" class="form-control" id="inputEmail3"
				placeholder="Email" name="email">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
		<div class="col-sm-9">
			<input type="password" class="form-control" id="inputPassword3"
				placeholder="Password" name="password">
		</div>
	</div>
	<div class="form-group">
		<label for="cityInput" class="col-sm-3 control-label">City</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="cityInput"
				placeholder="City" name="city">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-3">
			<div class="checkbox">
				<label> <a href="newUser.jsp">New User</a>
				</label>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-9">
			<button type="submit" class="btn btn-default">Sign in</button>
		</div>
	</div>
</form>


