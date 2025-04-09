

function Button({click, className ,text}){
	
	return(
		<button onClick={click} className={className} >{text}</button>
	);
}

export default Button;