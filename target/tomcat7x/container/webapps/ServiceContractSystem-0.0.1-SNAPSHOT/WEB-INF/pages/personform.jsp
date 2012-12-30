<%@ include file="/common/taglibs.jsp" %>

<head>
	<title><fmt:message key="personDetail.title"/></title>
	<meta name="heading" content="<fmt:message key="personDetail.heading"/>"/>
</head>

<div class="span7">
	<h2><fmt:message key="personDetail.heading"/></h2>
	<form:form commandName="person" method="post" action="${pageContext.request.contextPath}/personform" id="personForm">
		<form:errors path="*" cssClass="error" element="div"/>
		<form:hidden path="id"/>
		
		<ul>
		    <li>
		    	<appfuse:label styleClass="desc" key="person.firstName"/>
		    	<form:errors path="firstName" cssClass="fieldError"/>
				<form:input path="firstName" id="firstName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
			</li>
			<li>
				<appfuse:label styleClass="desc" key="person.lastName"/>
				<form:errors path="lastName" cssClass="fieldError"/>
				<form:input path="lastName" id="lastName" cssClass="text medium" cssErrorClass="text medium error" maxlength="50"/>
			</li>
		</ul>
		<fieldset class="form-actions">
			<button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false;">
				<i class="icon-ok icon-white"></i>
				<c:if test="${not empty person.id}"> 
					<fmt:message key="button.update"/>
				</c:if>
				<c:if test="${empty person.id}"> 
					<fmt:message key="button.save"/>
				</c:if>
			</button>
			<c:if test="${not empty person.id}">
				<button type="submit" class="btn" name="delete" onclick="bCancel=true;return confirmDelete('person')">
					<i class="icon-trash"></i> <fmt:message key="button.remove"/>
				</button>
			</c:if>
			<button type="submit" class="btn" name="cancel" onclick="bCancel=false;">
				<i class="icon-remove"></i> <fmt:message key="button.cancel"/>
			</button>
		</fieldset>
	</form:form>
</div>
