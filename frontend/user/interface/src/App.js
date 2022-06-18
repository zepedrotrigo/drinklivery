import {Routes, Route} from 'react-router-dom'

import Home from './pages/Home'

import Navbar from './components/Navbar'

import Wines from './pages/Wines';
import Profile from './pages/Profile';
import Checkout from './pages/Checkout';
import Enter from './pages/Enter';


function App() {
  



  return (
    <>
    <Navbar></Navbar>
    <Routes>
      <Route path="/" element={<Home/>}></Route>
      <Route path="/wines" element={<Wines/>}></Route>
      <Route path="/enter" element={<Enter/>}></Route>
      <Route path="/profile" element={<Profile/>}>
      <Route path="checkout" element={<Checkout/>}></Route>
      </Route>

    </Routes>
    </>
  );
}

export default App;