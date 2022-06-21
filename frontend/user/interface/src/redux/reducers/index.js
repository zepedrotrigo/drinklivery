import { combineReducers } from "redux";
import loggedReducer from "./loggedReducer";
import cartReducer from "./cartReducer";
import userReducer from "./userReducer";


const rootReducer = combineReducers({
    isLogged:loggedReducer,
    cart:cartReducer,
    user:userReducer,
})

export default rootReducer;