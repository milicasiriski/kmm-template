import SwiftUI
import shared

struct ItemScreen: View {
	let item: Item
	@StateObject var viewModel: ItemViewModel
	
	init(item: Item) {
		self.item = item
		self._viewModel = StateObject(wrappedValue: ItemViewModel(item: item))
	}
	
    var body: some View {
		Text(item.description_)
    }
}
