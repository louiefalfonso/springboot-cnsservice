import { Route, Routes, Navigate } from "react-router-dom";
import ProtectedRoute from "./services/ProtectedRoute"
function App() {
 
  const token = localStorage.getItem("token"); 

  return (

    <>
      <main className="w-full min-h-screen bg-[#f3f4f6] ">
        <Routes>
          <Route path="/" element={<Navigate to="/login" replace />} />

          
        </Routes>  
      </main>
    </>
  )
}

export default App
