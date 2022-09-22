import {  useNavigate} from "react-router-dom";


let VendorHome=()=>{

  let navigate=useNavigate();
    return(
   
                <div>
                <button onClick={()=>{navigate("/mechanic")}}>Add Mechanic</button> 
       
                <button onClick={()=>{navigate("/feedback")}}>View Feedbacks </button> 
           
         
              <button onClick={()=>{navigate("/offer")}}>Add offer</button>
           
      
              <button onClick={()=>{navigate("/booking")}}>Bookings</button>
           
      
              <button onClick={()=>{navigate("/update")}}>Update Profile </button>
         
              <button onClick={()=>{navigate("/login")}}>Log Out </button>
              </div>
    )
}


export default VendorHome;