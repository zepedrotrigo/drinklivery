import {Routes, Route} from 'react-router-dom'

import Home from './pages/Home'

import Navbar from './components/Navbar'

import './App.css';
import Drinks from './pages/Drinks';
import Profile from './pages/Profile';
import Checkout from './pages/Checkout';


function App() {
  



  return (
    <>
    <Navbar></Navbar>
    <Routes>
      <Route path="/" element={<Home/>}></Route>
      <Route path="/drinks" element={<Drinks/>}></Route>
      <Route path="/profile" element={<Profile/>}>
      <Route path="checkout" element={<Checkout/>}></Route>

      </Route>

    </Routes>
    </>
  );
}

export default App;