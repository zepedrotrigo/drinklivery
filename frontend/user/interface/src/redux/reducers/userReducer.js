const userReducer = (state = {}, action) => {
    if (action.type === 'SET_USER_INFO') {
        return action.payload;
    } else {
        return state;
    }
}

export default userReducer;