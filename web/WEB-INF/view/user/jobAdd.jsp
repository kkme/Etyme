<%@include file="header.jsp" %>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <div class="container">

      <form:form commandName="job" method="POST" action="jobAdd" style="width:80%;">
        <h3>Add Job</h3>
        <div class="row">
        <div class="col-md-6">
        	<form:hidden path="jobId"/>
			<div class="form-group">
				<form:label path="title">Title:</form:label>
				<form:input type="text" path="title" class="form-control" placeholder="E.g Senior Programmer" />
				<form:errors path="title" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label for="city" path="cityId">City, State:</form:label>
				<form:input type="text" path="cityId" id="city" class="form-control"></form:input>
				<form:errors path="cityId" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="salary">Salary:</form:label>
				<form:input type="text" path="salary" class="form-control" placeholder="per hour" />
				<form:errors path="salary" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="start_date">Start Date:</form:label>
				<form:input type="text" path="start_date" class="form-control" placeholder="per hour" />
				<form:errors path="start_date" cssClass="errors"></form:errors>
			</div>		
			<div class="form-group">
				<form:label path="jobtype.jobId">Job Type:</form:label>
				<form:select class="form-control" path="jobtype.jobId" items="${jobTypes}" itemValue="jobId" itemLabel="type">
				</form:select>
			</div>		
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<form:label path="duration">Duration:</form:label>
				<form:input type="text" path="duration" class="form-control" placeholder="E.g 6 months or 1 Year" />
				<form:errors path="duration" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="max_rate">Max Rate:</form:label>
				<form:input type="text" path="max_rate" class="form-control" placeholder="E.g 50 per hour" />
				<form:errors path="max_rate" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="openings">Openings:</form:label>
				<form:select class="form-control" path="openings" items="${openings}" >
				</form:select>
			</div>		
			<div class="form-group">
				<form:label path="company_reference">Company Job Reference:</form:label>
				<form:input type="text" path="company_reference" class="form-control" placeholder="Internal Reference" />
				<form:errors path="company_reference" cssClass="errors"></form:errors>
			</div>
			
		</div>
		</div>
		<hr>
		<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<form:label path="recruiterId">Recruiter:</form:label>
				<form:select class="form-control" path="recruiterId" items="${recruiter}" itemValue="userId" itemLabel="userName">
				</form:select>
			</div>		
			<div class="form-group">
				<form:label path="ownerId">Owner:</form:label>
				<form:select class="form-control" path="ownerId" items="${recruiter}" itemValue="userId" itemLabel="userName">
				</form:select>
			</div>		
		</div>
		</div>
		<hr>
		<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<form:label path="description">Description:</form:label>
				<form:textarea type="text" path="description" class="form-control" placeholder="" rows="15" />
				<form:errors path="description" cssClass="errors"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="skills">Skills Required:</form:label>
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
		</div>
		</div>
		<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<form:label path="status">Status:</form:label>
				<form:select class="form-control" path="status" items="${jobStatuses}" itemValue="id" itemLabel="status">
				</form:select>
			</div>				
			<div class="form-group">
				<form:label path="publish">Publish to portal:</form:label>
				<form:select class="form-control" path="publish">
					<form:option value="0">Yes</form:option>
					<form:option value="1">No</form:option>
				</form:select>
			</div>				
		</div>
		</div>
		<button class="btn btn-lg btn-primary" type="submit">Add Job</button>
        
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