import { useEffect, useState } from "react";

let VendorBooking=()=>{

   const[data,setData]=useState([])
   const[customer,SetCustomer]=useState([])
   const[vid,setId]=useState();
    useEffect(()=>{

        setId(localStorage.getItem("vid"))
        console.log("calling server API")
        fetch("http://localhost:8080/getOrderDetails/"+3)
        .then(resp => resp.json())
        .then(info => setData(info))
    },[]);
    
    const accept=(oid)=>{
        console.log("in accept")
        fetch("http://localhost:8080/activateorder/"+oid)
        .then(resp => resp.json())}
    
    
    return(
     
        <div>
        <h1>Booking Requests:</h1>
        <hr/>
            <table className="table table-bordered">
                
                       <tr>
                       <td>
                          <b>Date</b>
                       </td>
                       <td>
                           <b>Customer Name</b>
                       </td>
                       <td>
                           <b>Contact No</b>
                       </td>
                   </tr>
                    {
                    data.map((info)=>{
                        return(
                         
                            <tr>
                                <td>{info.servicedate}</td>
                                <td>{info.firstname} {info.lastname}</td>
                                <td>{info.contactno}</td>
                                <td><button onClick={accept(info.oid)} >Accept</button></td>
                            </tr>
                        )
                    })
                }
                
                
            </table>
        </div>
    )
}
export default VendorBooking;