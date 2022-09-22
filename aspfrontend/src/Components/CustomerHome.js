import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

function CustomerHome()
{
    let navigate=useNavigate();
     const [vendors,setVendors] =useState();
    const[flag,setFlag]=useState(false);
    function getAllVendors()
    {
        
        alert("in method")
        fetch("http://localhost:8080/getAllVendors")
        .then(res=>res.text())
        .then(data=>{
            const vendorsList=JSON.parse(data)
            setVendors(vendorsList)
            setFlag(true)
    })
    }
    useEffect(()=>{
        const uid=JSON.parse(localStorage.getItem("curUser")).userid
        fetch("http://localhost:8080/getCustomerByUserid/"+uid)
        .then(res=>res.json())
        .then(data=>{
            localStorage.setItem("CurCustomer",JSON.stringify(data))
        })
    },[])
    return(
  
       <div>
        <h1>welcome to the online servicing platform</h1>
        <button onClick={()=>{navigate("/getallvendors")}}>Get All vendors</button>
        <button>Give Feedback</button>
        <button>Add Vehicle</button>
        </div>

    );

}
export default CustomerHome;