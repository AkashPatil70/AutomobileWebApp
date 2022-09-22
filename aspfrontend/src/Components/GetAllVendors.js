import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

function GetAllVendors()
{
   let navigate=useNavigate();
       const[vendors,setVendors]=useState([]);
    useEffect(()=>{
        fetch("http://localhost:8080/getAllVendors")
        .then(res=>res.json())
        .then(data=>{
            
            setVendors(data)
           
           })
        },[])
     const setVendorsDetails=(vid,charges)=>{
            localStorage.setItem("vendorId",JSON.stringify(vid))
            localStorage.setItem("Vcharges",JSON.stringify(charges))
            navigate("/orderForm")
     }

    return(
     <div >
           <table border='1'>
           {vendors.map((v)=>{
                return(
                    <tr>
                    <td>{v.shopname}</td>
                    <td>{v.contactno}</td>
                    <td>{v.email}</td>
                    <td>{v.charges}</td>
                    <td><button onClick={setVendorsDetails(v.vendorid,v.charges)}>select</button></td>
                 </tr>
               
                )
            })}
                </table>
        </div>


    )
}
export default GetAllVendors;