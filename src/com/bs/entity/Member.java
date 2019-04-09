package com.bs.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.CascadeType;
import org.hibernate.annotations.BatchSize;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.hibernate.annotations.BatchSize;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.hibernate.annotations.BatchSize;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.hibernate.annotations.BatchSize;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_member")
public class Member {
	private int id;
	private Role roles;
	private String username;
	private String password;
	private String img;
	private String name;
	private String sex;
	private String tel;
	private String address;
	private String email;
	private User users;
	private List<Goods> goods;
	private List<Orders> orders;
	private List<CommentMsg> commentMsg;
	private List<MemberCollect> memberCollect;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",columnDefinition="int(11) comment '会员id,主键'")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Transient
	public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}
	@Transient
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Transient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="img",columnDefinition="varchar(200) DEFAULT NULL COMMENT '头像'")
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	@Column(name="name",columnDefinition="varchar(200) DEFAULT NULL COMMENT '姓名'")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="sex",columnDefinition="varchar(200) DEFAULT NULL COMMENT '性别'")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="tel",columnDefinition="varchar(200) DEFAULT NULL COMMENT '联系电话'")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name="address",columnDefinition="varchar(200) DEFAULT NULL COMMENT '住址'")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="email",columnDefinition="varchar(200) DEFAULT NULL COMMENT '邮箱'")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToOne
	@JoinColumn(name="users",columnDefinition="int(11) DEFAULT NULL COMMENT '登录账号id,外键'")
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	
	@BatchSize(size=10)
	@OneToMany(fetch=FetchType.LAZY,mappedBy="member",cascade={CascadeType.REMOVE})
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	
	@BatchSize(size=10)
	@OneToMany(fetch=FetchType.LAZY,mappedBy="member",cascade={CascadeType.REMOVE})
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	@BatchSize(size=10)
	@OneToMany(fetch=FetchType.LAZY,mappedBy="member",cascade={CascadeType.REMOVE})
	public List<CommentMsg> getCommentMsg() {
		return commentMsg;
	}
	public void setCommentMsg(List<CommentMsg> commentMsg) {
		this.commentMsg = commentMsg;
}
	
	@BatchSize(size=10)
	@OneToMany(fetch=FetchType.LAZY,mappedBy="member",cascade={CascadeType.REMOVE})
	public List<MemberCollect> getMemberCollect() {
		return memberCollect;
	}
	public void setMemberCollect(List<MemberCollect> memberCollect) {
		this.memberCollect = memberCollect;
	}
	
	public String toString() {
		return "Member [id=" + id+ "]";
	}

}

