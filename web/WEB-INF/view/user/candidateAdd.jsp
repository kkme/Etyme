<%@include file="header.jsp" %>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <div class="container">

      <form:form commandName="candidate" method="POST" action="candidateAdd" style="width:80%;">
        <h3>Add Candidate</h3>
        <div class="row">
        <div class="col-md-6">
        	<form:hidden path="candidateId"/>
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:input type="text" path="name" class="form-control" />
				<form:errors path="name" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input type="text" path="email" class="form-control" />
				<form:errors path="email" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="address">Address:</form:label>
				<form:input type="text" path="address" class="form-control" placeholder="Street , Town"/>
				<form:errors path="address" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label for="city" path="cityId">City, State:</form:label>
				<form:input type="text" path="cityId" id="city" class="form-control"></form:input>
				<form:errors path="cityId" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="homePhone">Home Phone:</form:label>
				<form:input type="text" path="homePhone" class="form-control" />
				<form:errors path="homePhone" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="cellPhone">Cell Phone:</form:label>
				<form:input type="text" path="cellPhone" class="form-control" />
				<form:errors path="cellPhone" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="workPhone">Work Phone:</form:label>
				<form:input type="text" path="workPhone" class="form-control"/>
				<form:errors path="workPhone" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="candidateSource.sourceId">Source:</form:label>
				<form:select class="form-control" path="candidateSource.sourceId" 
					items="${sourceTypes}" itemValue="sourceId" itemLabel="sourceName">
				</form:select>
			</div>					
			<div class="form-group">
				<form:label path="remarks">Remarks:</form:label>
				<form:input type="text" path="remarks" class="form-control"/>
				<form:errors path="remarks" cssClass="errors"></form:errors>
			</div>			
			<div class="form-group">
				<form:label path="canRelocate">Can Relocate:</form:label>
				<form:checkbox path="canRelocate" class="form-control"/>
				<form:errors path="canRelocate" cssClass="errors"></form:errors>
			</div>			
			<div class="form-group">
				<form:label path="salary">Salary:</form:label>
				<form:input type="text" path="salary" class="form-control" placeholder="per annum" />
				<form:errors path="salary" cssClass="errors"></form:errors>
			</div>
		</div>
		<div class="col-md-6">
		</div>
		</div>
		<hr>
		<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<form:label path="skills">Key Skills:</form:label>
				<br>
				<form:select path="skills" multiple="true" style="width:100%"
					id="skills">
				     <c:forEach var="map" items="${selectedSkills}">
				         <c:choose>
				             <c:when test="${fn:startsWith(map.key,'S')}">
				                 <option value="${map.value.skillId}" selected="selected">${map.value.name}</option>
				             </c:when>
				             <c:otherwise>
				                 <option value="${map.value.skillId}">${map.value.name}</option>
				             </c:otherwise>
				        </c:choose>
				    </c:forEach>
				</form:select>													
			</div>	
			<div class="form-group">
				<form:label path="otherKeySkills">Other Skills:</form:label>
				<form:input type="text" path="otherKeySkills" class="form-control"/>
				<form:errors path="otherKeySkills" cssClass="errors"></form:errors>
			</div>				
			<div class="form-group">
				<form:label path="notes">Notes:</form:label>
				<form:textarea type="text" path="notes" class="form-control" placeholder="" rows="5" />
				<form:errors path="notes" cssClass="errors"></form:errors>
			</div>
		</div>
		</div>
		<button class="btn btn-lg btn-primary" type="submit">Save</button>
        
      </form:form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
<script type="text/javascript">
$(document).ready(function() {    
    $("#city").select2({
        placeholder: "Search for a state",
        minimumInputLength: 3,
        ajax: { // instead of writing the function to execute the request we use Select2's convenient helper
	        url: "get_states",
	        dataType: 'json',
	        data: function (term, page) {
		        return {
			        q: term, // search term
			        page_limit: 10
		        };
	        },
	        results: function (data, page) { 
		        var res = [];
				for (var i = 0 ; i < data.length; i++) {
					res.push({ id: data[i][0], text: data[i][2] + "," + data[i][1]});
				}				
		        return {results: res};
	        }
        },
        initSelection: function(element, callback) {
            // the input tag has a value attribute preloaded that points to a preselected movie's id
            // this function resolves that id attribute to an object that select2 can render
            // using its formatResult renderer - that way the movie name is shown preselected
            var id=$('#city').val();
            if (id!=="0" && id!=="") {
                $.ajax("get_statesById", {
                    data: { 
                        id: id
                    },
                    dataType: "json"
                }).done(function(data) { 
    				var res = { id: data[0], text: data[2] + "," + data[1]};
                    callback(res); 
                });
            }
        }
    });

    $("#skills").select2({
        placeholder: "Search for a skill",
        minimumInputLength: 2
     });    

});    
</script>        
  </body>
</html>