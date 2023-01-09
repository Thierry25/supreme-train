    <%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf"%>
    <div class="container">
        <h1>Enter Todo Details</h1>
        <form:form method="post" modelAttribute="todo">
            <div class="form-group">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" cssClass="form-control" required="required" path="description" placeholder="Enter a description"/>
                    <from:errors path="description" cssClass="text-danger"/>
                </fieldset>

                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>
                <form:input type="hidden" class="form-control" path="id"/>
                <form:input type="hidden" class="form-control" path="done"/>
            </div>
            <button type="submit" class="btn btn-success">Submit</button>
        </form:form>
    </div>
    <%@include file="common/footer.jspf"%>
    <script type="text/javascript">
        $('#targetDate').datepicker({
            format: 'yyyy-mm-dd'
        });
    </script>
