<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="alert alert-primary text-dark border">
			<frm:form action="search" method="post" modelAttribute="report">
				<div class="row">

					<div class="col-4">
						<label class="text-dark fw-bold">Plan Name</label>
						<frm:select path="planName" cssClass="form-select w-75">
							<frm:option value="" label="--select--" />
							<c:forEach items="${planname}" var="plan">
								<frm:option value="${plan}" label="${plan}" />
							</c:forEach>
						</frm:select>
					</div>

					<div class="col-4">
						<label class="text-dark fw-bold">Plan Status</label>
						<frm:select path="planStatus" cssClass="form-select w-75">
							<frm:option value="" label="--select--" />
							<c:forEach items="${planstatus}" var="status">
								<frm:option value="${status}" label="${status}" />
							</c:forEach>
						</frm:select>
					</div>

					<div class="col-4">
						<label class="text-dark fw-bold">Gender</label>
						<frm:select path="gender" cssClass="form-select w-75">
							<frm:option value="" label="--select--" />
							<frm:option value="Male" />
							<frm:option value="Female" />
						</frm:select>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-4">
						<label class="text-dark fw-bold">Start Date</label>
						<frm:input path="startDate" type="date"
							cssClass="form-control w-75" />
					</div>

					<div class="col-4">
						<label class="text-dark fw-bold">End Date</label>
						<frm:input path="endDate" type="date" cssClass="form-control w-75" />
					</div>
				</div>

				<div class="row mt-4">
					<div class="col-12">
						<input type="reset" style="width: 100px;"
							class="btn btn-warning me-2 rounded fw-bold text-dark"> <input
							type="submit" style="width: 100px;"
							class="btn btn-success text-white fw-bold" value="Search">
					</div>
				</div>
			</frm:form>
		</div>
	</div>

	<div style="margin-top: -16px;">
		<table class="table  border rounded table-hover">
			<thead class="bg-black text-center text-white  ">
				<tr>
					<th>S.NO</th>
					<th>PLAN-NAME</th>
					<th>PLAN-STATUS</th>
					<th>GENDER</th>
					<th>START-DATE</th>
					<th>END-DATE</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty reports}">
						<c:forEach items="${reports}" varStatus="r" var="result">
							<tr class="text-center" >
								<td>${r.index + 1}</td>
								<td>${result.planName}</td>
								<td>${result.planStatus}</td>
								<td>${result.gender}</td>
								<td>${result.startDate}</td>
								<td>${result.endDate}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">
								<h1 class="text-danger text-center fw-bold">No Data Found</h1>
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
        <div class="ms-4 mt-3">
        <span class="fw-bold fs-4 me-3 p-1 mt-3 rounded rounded-2  border border-1 bg-dark text-white">EXPORT :</span>
        <a href="excel" class="btn ms-3 me-3 btn-outline-success  p-2" style="width: 100px">EXCEl</a>
        <a href="pdf" class="btn btn-outline-info p-2 text-dark " style="width: 100px">PDF</a>
        </div>
	</div>
</body>
</html>
