import {Routes, Route} from 'react-router-dom'

import AddRider from './pages/AddRider';

import Navbar from './components/Navbar'

import './App.css';
import Riders from './pages/Riders';
import Rider from './pages/Rider';

function App() {
  



  return (
    <>
    <Navbar></Navbar>
    <Routes>
      <Route path="/" element={<Riders/>}>
        <Route
        path={`rider/:riderId`}
        element={<Rider></Rider>}
        ></Route>
      </Route>
      <Route path="/add-rider" element={<AddRider/>}></Route>
    </Routes>
    </>
  );
}

export default App;
