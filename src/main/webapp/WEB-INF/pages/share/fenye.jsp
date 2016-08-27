<%@ page language="java" pageEncoding="UTF-8"%>
<div style="text-align: right;">
	
  <nav class="navbar navbar-default " role="navigation">
	<div >
		<p class="navbar-text" >
			总记录数:${formbean.total}条 | 每页显示:${formbean.pageSize}条 |
			总页数:${formbean.pages}页
		</p>
		<ul class=" pagination " >
			<c:if test="${1!= formbean.pages && formbean.pages!=null}">
				<c:if test="${1!= formbean.pageNum}">
					<li><a href="javascript:topage('${formbean.pageNum-1 }')">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${formbean.pageIndex.startindex}"
					end="${formbean.pageIndex.endindex}" step="1" var="page">
					<c:choose>
						<c:when test="${page== formbean.pageNum}">
							<li class="active"><a href="javascript:topage('${page }')">${page }</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:topage('${page }')">${page }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if
					test="${formbean.pages!=0 && formbean.pages!= formbean.pageNum }">
					<li><a href="javascript:topage('${formbean.pageNum+1 }')">&raquo;</a></li>
				</c:if>
			</c:if>
		</ul>
	</div>
  </nav>
</div>
