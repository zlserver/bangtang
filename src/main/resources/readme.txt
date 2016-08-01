
1.项目介绍
2.github操作说明
3.修改了

移动端：
注册,七天激活时间
	password：
	email:
http://localhost:8080/bangtang/mobile/common/register.action

登录
 	   email 邮箱
	 * password 密码
http://localhost:8080/bangtang/mobile/common/login.action

找回密码：
参数email
http://localhost:8080/bangtang/mobile/common/resPasLink/{email}.action

激活邮箱
参数 activeCode
http://localhost:8080/bangtang/mobile/common/activeEmail/{activeCode}.action

编辑头像
参数
   logo ：图片文件
   token：token值
http://localhost:8080/bangtang/mobile/client/editPic.action
