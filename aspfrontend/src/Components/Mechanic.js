
import { getAllByAltText } from '@testing-library/react';
import { useState } from 'react';
import './RegistationCSS.css';

let Mechanic=()=>{
    const[name,setName]=useState('')
    const[exp,setExp]=useState(0);
    const[vid,setId]=useState((localStorage.getItem("vendorinfo").vendorid))
    const[mechanic,setMechanic]=useState([]);
        const sendData=(e)=>{
        e.preventDefault();
        console.log("hi");
        const reqData = {
            method: "POST",
            headers: {
                "content-type":"application/json"
            },
            body: JSON.stringify({
                experience:exp,
                name:name,
                vendorid:vid
            })

        }
        fetch("http://localhost:8080/addmechanic",reqData)
        .then(res=> res.text() )
        
    }

   
    return (

     
         <form className="container, box">
              <h1>Add Mechanic:</h1>
            Name: <input type="text" name="name" onChange={(e)=>setName(e.target.value)} placeholder="Enter mechanic name"></input><br/>
            Experience:<input type="text" name="experience" placeholder='0' onChange={(e)=>setExp(e.target.value)}></input>
            <input type="hidden" name="vendorid" value={vid} ></input>  
            <button type="submit" onClick={(e)=>{sendData(e)}}>Add</button>
         </form>
       
         
         
    )
}

export default Mechanic;