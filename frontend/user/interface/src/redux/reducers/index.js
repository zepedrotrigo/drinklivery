import { combineReducers } from "redux";
import loggedReducer from "./loggedReducer";


const rootReducer = combineReducers({
    isLogged:loggedReducer,
})

export default rootReducer;