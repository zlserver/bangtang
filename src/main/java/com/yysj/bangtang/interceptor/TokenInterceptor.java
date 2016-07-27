package com.yysj.bangtang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yysj.bangtang.bean.Client;
import com.yysj.bangtang.myenum.OperationStatus;
import com.yysj.bangtang.service.ClientService;
import com.yysj.bangtang.utils.Log;
import com.yysj.bangtang.utils.SiteUtils;
import com.yysj.bangtang.utils.TokenGenerator;
import com.yysj.bangtang.utils.ValidateUtil;
import com.yysj.bangtang.vo.MyJsonFactory;

import net.sf.json.JSONObject;

public class TokenInterceptor implements HandlerInterceptor {

	private ClientService clientService;
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse resp, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		String uri=request.getRequestURI();
		String token =request.getParameter("token");
		Log.info(this, "uri:"+uri+"  token:"+token);
		//比较移动端的token和数据库中的是否一致
		try {
		    if( ValidateUtil.isValidateStr(token) ){
		    	//1.先从token中解析出email
				String email = TokenGenerator.getEmail(token);
				//2.查询数据库
				Client client =clientService.findByEmail(email);
				if( client !=null ){
					if( token.equals(client.getToken()))
						return true;
				}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		//让其先登录
		JSONObject  resetJson=MyJsonFactory.generator(OperationStatus.TOKEN_UNACCORDANCE);
		request.setAttribute("json", resetJson.toString());
		request.getServletContext().getRequestDispatcher("/WEB-INF/pages/"+SiteUtils.getPage("json")+".jsp").forward(request, resp);
		return false;
	}

	public ClientService getClientService() {
		return clientService;
	}
	@Autowired
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

}
