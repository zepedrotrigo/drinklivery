import { combineReducers } from "redux";
import loggedReducer from "./loggedReducer";
import userReducer from "./userReducer";


const rootReducer = combineReducers({
    isLogged:loggedReducer,
    user:userReducer,
})

export default rootReducer;