import { useState } from "react";
/*
버튼을 클릭하면 인풋창에 있는 내용이 h1태그안에 들어가도록 작성
*/

function MapSample(){
	let titles =["아침","점심","저녁","간식"]
	return(
		<div>
			<ul>
				{
					titles.map((v,i,arr)=>{
						return <li key={i}>{v}</li>
					})
				}
			</ul>
		</div>
	);
}

export default MapSample;