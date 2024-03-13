import SwiftUI

struct ErrorBanner: View {
	let text: String
	
	var body: some View {
		HStack {
			Image(systemName: "exclamationmark.circle")
				.foregroundColor(.white)
				.padding(.leading, 15)
				.padding(.trailing, 5)
			
			Text(NSLocalizedString(text, comment: ""))
				.foregroundColor(.white)
				.font(.caption)
				.padding(.leading, 5)
				.padding(.trailing, 15)
			
			Spacer()
		}
		.padding(.vertical, 10)
		.frame(maxWidth: .infinity)
		.background(Color.red)
	}
}

#Preview {
	ErrorBanner(text: "This is an error message")
}
