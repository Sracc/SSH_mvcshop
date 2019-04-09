package com.bs.actions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

import com.bs.entity.CommentMsg;
import com.bs.entity.Member;
import com.bs.entity.Search;
import com.bs.entity.User;
import com.bs.service.CommentMsgService;
import com.bs.service.GoodsService;
import com.bs.service.MemberService;
import com.bs.utils.PageContext;
import com.bs.utils.ResultUtils;



@Controller("commentMsgAction")
@Scope("prototype")
public class CommentMsgAction extends BaseAction {

	@Resource
	private CommentMsgService commentMsgService;
	@Resource
	private MemberService memberService ;
	@Resource
	private GoodsService goodsService ;
	private CommentMsg commentMsg;

	
	public String addInput(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "add_input";
	}
	public String add(){
		commentMsgService.add(commentMsg);
		return "add_success";
	}

	public String delete(){
		commentMsgService.delete(commentMsgService.findById(commentMsg.getId()));
		return "showlist";
	}
	public String deleteBetch(){
		String[] commentMsgIds = request.getParameterValues("commentMsgCheckbox");
		if(commentMsgIds!=null){
			for (int i = 0; i < commentMsgIds.length; i++) {
				commentMsgService.delete(commentMsgService.findById(Integer.parseInt(commentMsgIds[i])));
			}
		}
		return "showlist";
	}

	public String modify(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("commentMsg", commentMsgService.findById(commentMsg.getId()));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		PageContext.getPage().setPageSize(ps);
		request.setAttribute("search", search);
		return "update_commentMsg_input";
	}
	public String show(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int ps = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		request.setAttribute("commentMsg", commentMsgService.findById(commentMsg.getId()));
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		request.setAttribute("search", search);
		PageContext.getPage().setPageSize(ps);
		return "show";
	}

	public String update(){
		commentMsgService.update(commentMsg);
		commentMsgService.sessionFlush();
		commentMsgService.sessionRefresh(commentMsg);
		return "showlist";
	}
	
	public String get(){
		return "get";
	}

	public String list(){
		Search search = ResultUtils.copyParams(Search.class, request);
		int pageNo = PageContext.getPage().getPageNo();
		int pageSize = PageContext.getPage().getPageSize();
		PageContext.getPage().setPageSize(10000);
		User user = (User) request.getSession().getAttribute("login_user");
		request.setAttribute("page", PageContext.getPage());
		request.setAttribute("search", search);
		request.setAttribute("memberList", memberService.search(search));
		request.setAttribute("goodsList", goodsService.search(search));
		Member member = (Member) request.getSession().getAttribute("member");
		if("2".equals(user.getRole().getId()+"")&&search.getType().equals("backend")){
			search.setAuthorityName("member");
			search.setAuthorityValue(member.getId()+"");
		}
		PageContext.getPage().setPageNo(pageNo);
		PageContext.getPage().setPageSize(pageSize);
		request.setAttribute("commentMsgList", commentMsgService.search(search));
		return "list";
	}

	public Object getModel() {
		if(commentMsg == null){
			commentMsg = new CommentMsg();
		}
		return commentMsg;
	}

	
}

