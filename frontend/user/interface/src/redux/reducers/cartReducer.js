const cartReducer = (state = [], action) => {
    switch (action.type) {
        case 'ADD_TO_CART':
            return [...state, action.payload];
        case 'EMPTY_CART':
            return false;
        case 'REMOVE_FROM_CART':
            return state.pop(state[action.payload]);
        default:
            return state;
    }
}

export default cartReducer;