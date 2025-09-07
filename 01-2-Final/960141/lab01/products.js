const API_URL = "http://localhost:3000/product";


// Read Product
const productLists = document.getElementById("productLists");

async function getProductList() {
    try {
        const response = await fetch(API_URL);
        const items = await response.json();
        productLists.innerHTML = items.map(item => `
            <tr>
                <td>${item.productName}</td>
                <td>${item.price}</td>
                <td>${item.qty}</td>
            </tr>
        `).join('\n');
    } catch (error) {
        console.error('Error: ', error);
        alert('Failed to fetch product list');
    }
}

if(productLists) {
    // Initial load
    getProductList();
}

// Create Product

const addProductForm = document.getElementById("addProductForm");
if (addProductForm) {
    addProductForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const product_name = document.getElementById('product_name').value;
        const product_price = document.getElementById('product_price').value;
        const product_quantity = document.getElementById('product_quantity').value;
        
        const data = {
            productName: product_name,
            price: parseFloat(product_price),
            qty: parseInt(product_quantity, 10)
        }
        
        const body = document.querySelector('body');

        try {
            const response = await fetch(API_URL , {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });
            if(response.ok) {
                body.innerHTML += `<h2 class="msg_success"> Successfully added the new product</h2>
                                <a href="products.html">Go back to display all products</a>`
            } else {
                body.innerHTML += `<h2 class="msg_failed"> Failed to add the new product</h2>`
            }
        } catch (error) {
            console.error('Error: ', error);
            alert('Failed to add the product');
        }
    });
}

// Update Product

async function getProductList() {
    try {
        const response = await fetch(API_URL);
        const items = await response.json();
        productLists.innerHTML = items.map(item => `
            <tr>
                <td>${item.productName}</td>
                <td>${item.price}</td>
                <td>${item.qty}</td>
                <td>
                    <img src="img/edit.png" style="width: 24px;height: 24px;" class="icon btn_update" data-productId="${item.productID}" data-action="update">
                    <img src="img/delete.png" style="width: 24px;height: 24px;" class="icon btn_delete" data-productId="${item.productID}" data-action="delete">
                </td>
            </tr>
        `).join('\n');
        attachEventListener();
    } catch (error) {
        console.error('Error: ', error);
        alert('Failed to fetch product list');
    }
}

if(productLists) {
    // Initial load
    getProductList();
}

function attachEventListener() {
    const btnAction = document.querySelectorAll('.btn_update, .btn_delete');
    if(btnAction) {
        btnAction.forEach(btn => {
            btn.addEventListener('click', event => {
                const productID = event.target.getAttribute('data-productID');
                const action = event.target.getAttribute('data-action');
                if (action === 'update') {
                    window.location.href = `updateProduct.html?productID=${productID}`;
                } else if (action ==='delete'){
                    deleteProduct(productID);
                }
            });
        });
    }
}

async function getProductForUpdate(productID) {
    try {
        const response = await fetch(`${API_URL}/${productID}`);
        if (response.ok) {
            const item = await response.json();
            document.getElementById('product_name').value = item[0].productName;
            document.getElementById('product_price').value = item[0].price;
            document.getElementById('product_quantity').value = item[0].qty;
        } else {
            alert('Product not found');
        }
    } catch (error) {
        console.error('Error: ', error);
        alert('Failed to fetch product details');
    }
}

const updateForm = document.getElementById("updateProductForm");
if (updateForm) {
    const urlParams = new URLSearchParams(window.location.search);
    const productID = urlParams.get('productID');

    if (productID) {
        getProductForUpdate(productID);
    }

    updateForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const product_name = document.getElementById('product_name').value;
        const product_price = document.getElementById('product_price').value;
        const product_quantity = document.getElementById('product_quantity').value;
        
        const data = {
            productName: product_name,
            price: parseFloat(product_price),
            qty: parseInt(product_quantity, 10)
        }

        try {
            const response = await fetch(`${API_URL}/${productID}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            });

            const body = document.querySelector('body');

            if(response.ok) {
                body.innerHTML += `<h2 class="msg_success"> Successfully updated the product</h2>
                                <a href="products.html">Go back to display all products</a>`
            } else {
                body.innerHTML += `<h2 class="msg_failed"> Failed to update the product</h2>`
            }
        } catch (error) {
            console.error('Error: ', error);
            alert('Failed to update the product');
        }
    });
}

async function deleteProduct(productId) {
    let text = "Do you want to delete the product?";
    if (confirm(text) == true) {
        try {
            const response = await fetch(`${API_URL}/${productId}`, {
                method: 'DELETE'
            });
            if(response.ok) {
                alert('Product deleted successfully');
                getProductList(); // Refresh the product list
            } else {
                alert('Failed to delete the product');
            }
        } catch (error) {
            console.error('Error: ', error);
            alert('Failed to delete the product');
        }
    }
}