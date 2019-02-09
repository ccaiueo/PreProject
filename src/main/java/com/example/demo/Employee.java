package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

// JPAで使用

@Entity(name="Employee") // Entityクラスであることを明記。name属性はテーブル名で。
public class Employee {
		@Id
	    private String id;
		private String name;
		private String email;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
		}


}
