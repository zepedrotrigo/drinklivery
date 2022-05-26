import {Routes, Route} from 'react-router-dom'

import Home from './pages/Home'
import AddRider from './pages/AddRider';

import Navbar from './components/Navbar'

import './App.css';

function App() {
  



  return (
    <>
    <Navbar></Navbar>
    <Routes>
      <Route path="/" element={<Home/>}></Route>
      <Route path="/add-rider" element={<AddRider/>}></Route>
    </Routes>
    </>
  );
}

export default App;
