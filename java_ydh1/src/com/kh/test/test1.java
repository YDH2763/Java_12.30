package com.kh.test;
import java.util.ArrayList;
import java.util.List;

import com.kh.test.shape.model.vo.Person;
public class test1 {

	public static void main(String[] args) {
		Person[] pArr=new Person[3];
		List<Person> list=new ArrayList<Person>();
		for(int i=0;i<pArr.length;i++) {
			list.add(pArr[i]);
			System.out.println(list.get(i));
		}

	}

}
