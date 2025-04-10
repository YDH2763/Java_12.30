import {BrowserRouter, Link, Route, Routes} from 'react-router-dom'
import PostList from "./PostList.js";
import PostInsert from "./PostInsert";
import Main from "./Main";
import Nav from './Nav.js';
import PostDetail from './PostDetail.js';
import Signup from './Signup.js';

function App() {
  
 
  return (
    <BrowserRouter>
     <Nav/>
      <Routes>
        <Route path='/' exact element={<Main/>}/>
        <Route path='/post/list/:num' element={<PostList/>}/>
        <Route path='/post/detail/:num' element={<PostDetail/>}/>
        <Route path='/signup' element={<Signup/>}/>
        {/* <Route path='/post/insert' element={<PostInsert/>}/> */}
      </Routes>
    </BrowserRouter>   
  );
}

export default App;
