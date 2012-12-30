<%@ include file="/common/taglibs.jsp" %>

<head>
	<title><fmt:message key="personList.title"/></title>
	<meta name="heading" content="<fmt:message key="personList.heading"/>"/>
	<meta name="menu" content="PersonMenu"/>
</head>

<div class="span10">
	<h2><fmt:message key="personList.heading"/></h2>
	
	<div id="actions" class="form-actions">
		<a class="btn btn-primary" href="<c:url value="/personform/"/>"><i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
		<a class="btn" href="<c:url value="/mainMenu"/>"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
	</div>
	
	<display:table name="personList" class="table table-condensed table-hover table-striped" requestURI="" id="personList" export="true" pagesize="25">
		<display:column property="id" sortable="true" href="personform" paramId="id" paramProperty="id" titleKey="person.id"/>
		<display:column property="firstName" sortable="true" titleKey="person.firstName"/>
		<display:column property="lastName" sortable="true" titleKey="person.lastName"/>
		
		<display:setProperty name="paging.banner.items.name"><fmt:message key="personList.person"/></display:setProperty>
		<display:setProperty name="paging.banner.items_name"><fmt:message key="personList.persons"/></display:setProperty>
		
		<display:setProperty name="export.excel.filename">Persons.xsl</display:setProperty>
		<display:setProperty name="export.csv.filename">Persons.csv</display:setProperty>
		<display:setProperty name="export.pdf.filename">Persons.pdf</display:setProperty>
	</display:table>
</div>

<script type="text/script">
	highlightTableRows("personList");
</script>