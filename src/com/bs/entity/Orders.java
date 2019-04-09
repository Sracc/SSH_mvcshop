package com.bs.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_orders")
public class Orders {
	private int id;
	private Member member;
	private Goods goods;
	private int nums;
	private Date settime;
	private State state;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",columnDefinition="int(11) comment '订单id,主键'")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="member",columnDefinition="int(11) DEFAULT NULL COMMENT '下单人id,外键'")
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@ManyToOne
	@JoinColumn(name="goods",columnDefinition="int(11) DEFAULT NULL COMMENT '商品id,外键'")
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	@Column(name="nums",columnDefinition="int(11) DEFAULT NULL COMMENT '购买数量'")
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	
	@Column(name="settime",columnDefinition="datetime DEFAULT NULL COMMENT '下单时间'")
	public Date getSettime() {
		return settime;
	}
	public void setSettime(Date settime) {
		this.settime = settime;
	}
	
	@ManyToOne
	@JoinColumn(name="state",columnDefinition="int(11) DEFAULT NULL COMMENT '订单状态id,外键'")
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public String toString() {
		return "Orders [id=" + id+ "]";
	}

}

