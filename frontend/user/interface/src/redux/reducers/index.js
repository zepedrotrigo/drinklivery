import { combineReducers } from "redux";
import loggedReducer from "./loggedReducer";
import cartReducer from "./cartReducer"


const rootReducer = combineReducers({
    isLogged:loggedReducer,
    cart:cartReducer
})

export default rootReducer;