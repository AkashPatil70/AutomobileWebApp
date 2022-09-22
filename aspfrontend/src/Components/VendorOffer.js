import { useState } from "react";


let VendorOffer=()=>{
    
        const[oname,setName]=useState('')
        const[description,setDesc]=useState();
        const[vendorid,setId]=useState((localStorage.getItem("vendorinfo")).vendorid)
            const sendData=(e)=>{
            e.preventDefault();
            console.log("hi");
            const reqData = {
                method: "POST",
                headers: {
                    "content-type":"application/json"
                },
                body: JSON.stringify({
                    offername:oname,
                    offer_description:description,
                    vendorid:vendorid
                })
    
            }
            fetch("http://localhost:8080/addoffer",reqData)
            .then(res=> res.text() )
            
        }
       
        return (
            
           
             <form className="container, box">
                  <h1>Add Offer:</h1>
                Name: <input type="text" name="offername" onChange={(e)=>setName(e.target.value)} placeholder="Enter mechanic name"></input><br/>
                Experience:<input type="text" name=" offer_description" placeholder='0' onChange={(e)=>setDesc(e.target.value)}></input>
                <input type="hidden" name="vendorid" value={vendorid} ></input>  
                <button type="submit" onClick={(e)=>{sendData(e)}}>Add Offer</button>
                
             </form>
             
        )
}
export default VendorOffer;