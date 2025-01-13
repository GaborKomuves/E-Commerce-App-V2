const API_URL = '/api/products';

function addProduct() {
    const productData = { name: 'New Product', price: 10.99, category: 'Tools' };
    fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(productData),
    }).then(response => response.json()).then(data => {
        alert('Product added!');
        location.reload();
    });
}

function editProduct(productId) {
    const updatedData = { name: 'Updated Product', price: 15.99, category: 'Tools' };
    fetch(`${API_URL}/${productId}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(updatedData),
    }).then(response => response.json()).then(data => {
        alert('Product updated!');
        location.reload();
    });
}

function deleteProduct(productId) {
    fetch(`${API_URL}/${productId}`, { method: 'DELETE' }).then(() => {
        alert('Product deleted!');
        location.reload();
    });
}
