import React, {useEffect, useState} from 'react';
import axios from 'axios';

const Home = () => {
  const [fetched, setFetched] = useState(false);


  // useEffect(() => {
  //     if (!fetched) {
  //       axios.get("/")
  //     }
  // })


  return (
    <div className="pl-[10%] pr-[10%] w-full">
      <p className="text-4xl font-bold mt-24 text-center">You have no active requests!</p>
    </div>
  )
}

export default Home