import {useEffect, useState, useReducer } from "react";
import './RegistrationCSS.css'
const init={
  servicedate:"1998-12-12 12:12:00",
  customerid:(JSON.parse(localStorage.getItem("CurCustomer"))).customerid,
  vendorid:(localStorage.getItem("vendorId")),
  userid:3,
  offerid:2,
  vehicleid:1,
  totalamount:(localStorage.getItem("Vcharges"))
}

const reducer=(state,action)=>{
  switch(action.type){
      case 'update':
          return { ...state, [action.field]: action.val};
  }
}
function OrderForm()
{
   const[order,setOrder]=useReducer(reducer,init);
    const[vehicles,setVehicles]= useState([]);
    const[Offers,setOffers]= useState([]);
    useEffect(()=>{
      fetch("http://localhost:8080/getOffersByVendorID/"+localStorage.getItem("vendorId"))
      .then(res=>res.json())
      .then(data=>setOffers(data))
      },[])

    useEffect(()=>{
        
        fetch("http://localhost:8080/getVehiclesByCustomerID/"+(JSON.parse(localStorage.getItem("CurCustomer"))).customerid)
        .then(res=>res.json())
        .then(data=>setVehicles(data))
      },[])

  
      const reqData = {
        method: "POST",
        headers: {
            "content-type":"application/json"
        },
        body: JSON.stringify({

            servicedate:order.servicedate,
            customerid:order.customerid,
            vendorid:order.vendorid,
            userid:order.userid,
            offerid:order.offerid,
            vehicleid:order.vehicleid,
            totalamount:order.totalamount
        })
      }
     
const sendData=()=>{
  alert(order.servicedate)
  alert(order.offerid)
      fetch("http://localhost:8080/addorder",reqData)
      .then(res=>res.json())
      .then(data=>{alert(data)})

    }

  return(
      
      <form  className="box" >
      <h1>Place your order</h1><br /><br />
            <div >
            
            
             select Date: <input type="Date" name="servicedate" required  onChange={(e)=>setOrder({type:'update', field:'servicedate' , val:e.target.value})}></input>
           </div>
            <br/>

            <div>
        
      select vehicle:<select  name="vehicle" required   onChange={(e)=>setOrder({type:'update', field:'vehicleid' , val:e.target.value})}>
            <option>(select one)</option>
  {vehicles.map((vehicles)=>{return <option value={vehicles.vehicleid}>{vehicles.vehiclemodel} - ({vehicles.vehicleno})</option>})}
            </select>
            </div>
            <br/>
            
           <div>
      
            select Offer: <select  name="offer" required   onChange={(e)=>setOrder({type:'update', field:'offerid' , val:e.target.value})}>
           <option>(select one)</option>
  {Offers.map((Offers)=>{return <option value={Offers.offerid}>{Offers.offername}</option>})}
           </select>
           </div>
           <br/>
          
        <button onClick={sendData}>Place Order</button>
           
            </form>
            
  );
}
export default OrderForm;