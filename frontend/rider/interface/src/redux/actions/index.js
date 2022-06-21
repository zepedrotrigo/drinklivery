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

export const setUserInfo = (item) =>{
    return {
        type: 'SET_USER_INFO',
        payload:item,
    }
}
