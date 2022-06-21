import React, { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import axios from 'axios';


const Checkout = () => {

  const [fetched, setFetched] = useState(false);
  const [emptyCart, setEmptyCart] = useState(false);
  const [cart, setCart] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);

  const user = useSelector(state => state.user);

  useEffect(() => {
    if (!fetched) {
      let tempPrice = 0;
      if (localStorage.getItem('cart')) {
        setCart(JSON.parse(localStorage.getItem('cart')));

        for (const item of JSON.parse(localStorage.getItem('cart'))) {
          tempPrice += item.quantity * item.wine.buyPrice;
        }
        setTotalPrice(tempPrice);
        setFetched(true);
      }
      else setEmptyCart(true);
    }
  })




  const processBuy = () => {
    let items = [];
    for (const item of cart) {
      for (let i = 0; i < item.quantity; i++) items.push(item.wine);
    }

    const body = {
      productList: items,

    }

    const options = {
      headers: {
        'content-type': 'application/json'
      }
    }

    axios.post("/request", body, options)
      .then(response => {
        console.log(response);
        localStorage.removeItem("cart");
        setFetched(false);
      })
      .catch(err => {
        console.log(err)
      })

  }

  return (
    <div className="mt-16 bg-primary/20 px-16 py-8 rounded-xl flex flex-col">
      <p className="text-3xl font-bold">Checkout</p>
      {emptyCart ?
        <p className="mt-2">Cart is empty</p>
        :
        <>
          <p className="text-xl font-medium mt-4">Total Price: <span className="ml-3 font-normal">{totalPrice}€</span></p>
          <p className="text-xl font-medium mt-1">Payment: <span className="ml-3 font-normal">Card</span></p>
          <p className="text-xl font-medium mt-1">Delivery: <span className="ml-3 font-normal">Your Home</span></p>
          <button className="bg-primary-shade-6 px-4 py-2 text-white rounded-xl text-xl self-end" onClick={processBuy}>Buy!</button>
        </>
      }
    </div>
  )
}

export default Checkout