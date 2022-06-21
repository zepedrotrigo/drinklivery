import './App.css';

import { Routes, Route } from 'react-router';
import { useSelector } from 'react-redux';
import Login from './pages/Login';
import Home from './pages/Home';

function App() {

  const isLogged = useSelector(state => state.isLogged);

  return (
    <>
    <Routes>
      <Route path="/" element={isLogged ? <Home/>: <Login/>}></Route>
    </Routes>
    </>
  );
}

export default App;
