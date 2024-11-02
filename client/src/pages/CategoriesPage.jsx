
import React from "react";
import MainLayout from "../components/layout/MainLayout";
import Categories from "../components/categories/Categories";


const CategoriesPage = () => {
  return (
    <>
      <MainLayout>
        <div className="flex flex-col gap-4 min-h-[calc(100vh-212px)]">
          <Categories/>
        </div>
      </MainLayout>
    </>
  );
};

export default CategoriesPage;
