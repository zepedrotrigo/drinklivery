export const signIn = () =>{
    return {
        type: 'SIGN_IN'
    }
}

export const signOut = () =>{
    return {
        type: 'SIGN_OUT'
    }
}

export const addToCart = (item) =>{
    return {
        type: 'ADD_TO_CART',
        payload:item,
    }
}

export const emptyCart = () =>{
    return {
        type: 'EMPTY_CART'
    }
}

export const removeFromCart = (index) =>{
    return {
        type: 'REMOVE_FROM_CART',
        payload:index
    }
}

export const setUserInfo = (item) =>{
    return {
        type: 'SET_USER_INFO',
        payload:item,
    }
}
