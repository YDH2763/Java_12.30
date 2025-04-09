import { useState } from "react";


function ToDoList(){
	let [list,setList] =useState(["등원","1교시"]);
	let [toDo,setToDO] =useState("");
	
	function submit(e){
		e.preventDefault();
		//toDo가 비워있으면 alert으로 알림후 종료
		if(toDo.trim().length==0){
			alert("할일을 입력하세요.");
			return;
		}
		//리스트에 todo를 추가
		setList([...list,toDo]);
		setToDO("");
	}
	return(
		<div>
			<from onSubmit={submit}>
				<input type="text" onChange={(e)=>setToDO(e.target.value)} value={toDo}/>
				<button>등록</button>
			</from>
			<h1>오늘의 할일</h1>
			<ul>
				{
					list.map(v=><li>{v}</li>)
				}

			</ul>
		</div>
	);
}

export default ToDoList;