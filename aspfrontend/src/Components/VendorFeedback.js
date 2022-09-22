
import { useState } from "react";
import { useEffect } from "react";

let VendorFeedback=()=>{
    const[data,setData]=useState([])
    const[vid,setId]=useState((localStorage.getItem("vendorinfo")).vendorid)
     useEffect(()=>{
        cnt=0;
    
         console.log("calling server API")
         fetch("http://localhost:8080/getAllFeedbackById/"+vid)
         .then(resp => resp.json())
         .then(info => setData(info))
     },[]);
    
    let cnt=1;
     return(
          
         <div>
         <h1>Feedbacks :</h1>
         <hr/>
             <table className="table table-bordered">
                 
                        <tr>
                        <td>
                           <b>Sr.No</b>
                        </td>
                        <td>
                            <b>Feedback</b>
                        </td>
                    </tr>
                     {
                     data.map((info)=>{
                         return(
                            
                             <tr>
                                
                                 <td>{cnt++}</td>
                                 <td>{info.description}</td>
                             </tr>
                         )
                     })
                 }
                 
                 
             </table>
         </div>
     )
}
export default VendorFeedback;